<p align="center"> 
    <h3 align="center"><img alt="ABUNAI" src="abunai-art-240.png"><br>
    ABUNAI</h3>
</p>
<p>&nbsp;</p>

## ABUNAI: Architecture-Based and Uncertainty-Aware Confidentiality Analysis

[![xDECAF analysis framework](https://img.shields.io/badge/xDECAF%20analysis%20framework-v4.0.0-orange?style=flat-square&logo=eclipse&logoColor=white)](https://dataflowanalysis.org)
[![Dissertation](https://img.shields.io/badge/Dissertation-Available-green?style=flat-square&logo=GitBook&logoColor=white)](https://doi.org/10.5445/IR/1000178700)
[![Overview Slides](https://img.shields.io/badge/Overview%20Slides-Available-green?style=flat-square&logo=Slides&logoColor=white)](https://sebastianhahner.de/talks/2024/DoctoralDefenseSebastianHahner_2024_ArchitectureBasedAndUncertaintyAwareConfidentialityAnalysis.pdf)

ABUNAI is the core analysis of the ABUNAI approach to uncertainty-aware confidentiality analysis.
This repository provides tool support for the fourth step of the procedure shown below: The confidentiality analysis under uncertainty.
For further information, please see the [dissertation](https://doi.org/10.5445/IR/1000178700) *Chapter 4.1* on the procedure and *Chapter 7* on the uncertainty-aware data flow analysis
to identify confidentiality violations.
<p>&nbsp;</p>

![Procedure](abunai-light.png#gh-light-mode-only)
![Procedure](abunai-dark.png#gh-dark-mode-only)

## Overview
This analysis can analyze the impact of uncertainty on confidentiality and identify confidentiality violations due to uncertainty.
It uses modeled uncertainty scenarios supporting both data flow diagrams (DFD) and the Palladio Component Model (PCM).
The analysis is based on the xDECAF analysis framework, see https://dataflowanalysis.org.

## Installation

1. Download the [data flow analysis](https://github.com/DataFlowAnalysis) product from [product.dataflowanalysis.org](https://updatesite.palladio-simulator.com/DataFlowAnalysis/product/releases/4.0.0/).
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
