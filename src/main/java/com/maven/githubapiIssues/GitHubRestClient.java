package com.maven.githubapiIssues;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GitHubRestClient {

    public String requestIssues(String username, String password, String state)
            throws FileNotFoundException, MalformedURLException {

        String JSONContent = null;

        HttpGet httpget = new HttpGet("");

        HttpHost target = new HttpHost("api.github.com", 443, "https");
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(target.getHostName(), target.getPort()),
                new UsernamePasswordCredentials(username, password));

        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider).build();

        AuthCache authCache = new BasicAuthCache();
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(target, basicAuth);

        HttpClientContext localContext = HttpClientContext.create();

        localContext.setAuthCache(authCache);

        if (state == ("open")) {
            httpget = new HttpGet(
                    "/repos/SoftwareStudioSpring2018/githubapi-issues-bnpalekhya/issues?state=open");
        }
        else if (state == ("closed")) {
            httpget = new HttpGet(
                    "/repos/SoftwareStudioSpring2018/githubapi-issues-bnpalekhya/issues?state=closed");
        }

        try {

            CloseableHttpResponse response = httpclient.execute(target, httpget,
                    localContext);

            System.out.println(response.getStatusLine());

            HttpEntity entity = response.getEntity();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(entity.getContent()));

            JSONContent = reader.readLine();

            EntityUtils.consume(entity);

        }
        catch (ClientProtocolException e) {

            e.printStackTrace();
        }
        catch (IOException e) {

            e.printStackTrace();
        }
        finally {

            authCache.clear();

        }

        return JSONContent;

    }

}
