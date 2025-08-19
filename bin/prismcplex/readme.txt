This wrapper class is design for connecting between PRISM & CPLEX.

Steps needed:


1. For prismcplex
1.1 Build Path --> Configure Build PAth --> Library --> Add external JARS --> Add cplex.jar
1.2 Export --> Runnable JAR file (copy required library into sub-folder) --> results: prismcplex.jar & prismcplex_lib folder (this folder contain cplex.jar)


2 Delete or move the folder prismcplex_lib --> anywhere. 
2.1 The reason is to disconnect prismcplex.jar & prismcplex_lib  --> when we do the below step 3, 
2.2 the cplex.jar would not be added into Referenced Libraries (when doing step 3-1), and would not be added into PrismAlpha1.0.32_lib (when doing step 3-2)


3. For prism
3.1 Build Path --> Configure Build PAth --> Library --> Add external JARS --> Add prismcplex.jar. 
3.2 Export --> Runnable JAR file (copy required library into sub-folder) --> results: PrismAlpha1.0.32.jar & PrismAlpha1.0.32_lib folder (this folder would not contain cplex.jar because of step 2)

4. Now in order to run cplex, we need:
4.1 Create the folder "prismcplex_lib" which contains the cplex.jar file, and put the whole folder into "PrismAlpha1.0.32_lib" (created in step 3.2)
4.2 In "Temporary" folder we need to have the .dll file associated with the cplex.jar file (i.e. each CPLEX package would have a cplex.jar and an associated cplex****.dll, where **** is a number for example 1261)