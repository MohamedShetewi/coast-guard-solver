import os

strategies = ["DF", "GR1", "GR2", "AS1", "AS2", "BF", "ID"]
args = "java -jar ../out/artifacts/Coast_Guard_Solver_jar/Coast-Guard-Solver.jar "

for strategy in strategies:
    print(args + strategy)
    os.system(args + strategy)
