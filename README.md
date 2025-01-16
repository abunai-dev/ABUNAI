# UncertaintyAwareConfidentialityAnalysis
This analysis can analyze the impact of uncertainty on confidentiality and identify confidentiality violations due to uncertainty.
It uses modeled uncertainty scenarios supporting both data flow diagrams (DFD) and the Palladio Component Model (PCM).
The analysis is based on the data flow analysis project, see https://github.com/DataFlowAnalysis/DataFlowAnalysis.

## Installation

1. Download the nightly version of the DFA product: https://updatesite.palladio-simulator.com/DataFlowAnalysis/product/nightly/
2. Extract all files from the archive, launch Eclipse and choose a folder as workspace (or just take the default one).
3. Clone the data flow analysis into the workspace, which can be found [here](https://github.com/DataFlowAnalysis/DataFlowAnalysis).
4. Clone this repository into the workspace.
5. Import all projects of the data flow analysis and also all projects from the bundles and tests folders from this repository using *File->Import->General->Existing Projects* into Workspace.
6. Execute the tests cases to make sure everything is working correctly.
7. Optional: Refer to the example scenarios available at https://abunai.dev for more interesting analysis results.
8. Optional: To develop with the analysis, install the following bundles using *Help -> Install new Software...*
    * https://download.eclipse.org/releases/2023-03/
       * Ecore Diagram Editor (SDK)
       * EMF - Eclipse Modeling Framework SDK
       * UML2 Extender SDK
    * https://updatesite.palladio-simulator.com/palladio-core-pcm/releases/5.2.0/
       * Palladio Component Model Developer Resources
    * https://updatesite.palladio-simulator.com/palladio-core-commons/releases/5.2.0/
       * Palladio Simulator Commons Feature Developer Resources
