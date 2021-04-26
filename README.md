# dom4j
dom4j is an open source framework for processing XML which is integrated with XPath and fully supports DOM, SAX, JAXP and the Java platform such as Java 2 Collections.

Version 1.6.2 Bug fix release.

This is an Atlassian fork of dom4j 

See original source here https://github.com/dom4j/dom4j

Track changes on the Atlassian fork here https://github.com/atlassian/dom4j

## Release process
Just release from your local copy. Do to do so you first need to have the permissions to upload to PAC*
1. Read this instruction to learn how to grant yourself write permission to PAC:
https://hello.atlassian.net/wiki/spaces/RELENG/pages/852378105/HOWTO+-+Get+temporary+write+permission+on+artifactory

2. From the root of the project run: `mvn release:prepare`
This will run in the interactive mode. You will be asked to verify version numbers, however the defaults should be correct.
   
3. From the root run: `mvn release:perform`.
   This pushes the artifact to PAC and bump versions in *.pom for next development iteration. It does push changes
   to origin but better doublecheck.
4. Verify that the artifact has been successfully uploaded to PAC.

* If this is indeed the case you'll see similar error in you mvn output
"Failed to deploy artifacts [...] 401 Unauthorized"

PS. Although the buildplans for releasing to PAC are present on Ecosystem the release step fails:
https://ecosystem-bamboo.internal.atlassian.com/browse/DOM4J

## Supported Branches 

- master
- version-2.0.x
- 1.6.x

## Other information 

- See CHANGELOG.md for changes made after the fork
- LICENCE.txt for licensing information

