import React, { Component } from 'react'
import SteadyStateHypothesisVersionService from '../services/SteadyStateHypothesisVersionService'

class ListSteadyStateHypothesisVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                steadyStateHypothesisVersions: []
        }
        this.addSteadyStateHypothesisVersion = this.addSteadyStateHypothesisVersion.bind(this);
        this.editSteadyStateHypothesisVersion = this.editSteadyStateHypothesisVersion.bind(this);
        this.deleteSteadyStateHypothesisVersion = this.deleteSteadyStateHypothesisVersion.bind(this);
    }

    deleteSteadyStateHypothesisVersion(id){
        SteadyStateHypothesisVersionService.deleteSteadyStateHypothesisVersion(id).then( res => {
            this.setState({steadyStateHypothesisVersions: this.state.steadyStateHypothesisVersions.filter(steadyStateHypothesisVersion => steadyStateHypothesisVersion.steadyStateHypothesisVersionId !== id)});
        });
    }
    viewSteadyStateHypothesisVersion(id){
        this.props.history.push(`/view-steadyStateHypothesisVersion/${id}`);
    }
    editSteadyStateHypothesisVersion(id){
        this.props.history.push(`/add-steadyStateHypothesisVersion/${id}`);
    }

    componentDidMount(){
        SteadyStateHypothesisVersionService.getSteadyStateHypothesisVersions().then((res) => {
            this.setState({ steadyStateHypothesisVersions: res.data});
        });
    }

    addSteadyStateHypothesisVersion(){
        this.props.history.push('/add-steadyStateHypothesisVersion/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SteadyStateHypothesisVersion List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSteadyStateHypothesisVersion}> Add SteadyStateHypothesisVersion</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> BaseUML </th>
                                    <th> BaseURI </th>
                                    <th> Date </th>
                                    <th> DifferenceModelURI </th>
                                    <th> EntsoeUML </th>
                                    <th> EntsoeURI </th>
                                    <th> ModelDescriptionURI </th>
                                    <th> NamespaceRDF </th>
                                    <th> NamespaceUML </th>
                                    <th> ShortName </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.steadyStateHypothesisVersions.map(
                                        steadyStateHypothesisVersion => 
                                        <tr key = {steadyStateHypothesisVersion.steadyStateHypothesisVersionId}>
                                             <td> { steadyStateHypothesisVersion.baseUML } </td>
                                             <td> { steadyStateHypothesisVersion.baseURI } </td>
                                             <td> { steadyStateHypothesisVersion.date } </td>
                                             <td> { steadyStateHypothesisVersion.differenceModelURI } </td>
                                             <td> { steadyStateHypothesisVersion.entsoeUML } </td>
                                             <td> { steadyStateHypothesisVersion.entsoeURI } </td>
                                             <td> { steadyStateHypothesisVersion.modelDescriptionURI } </td>
                                             <td> { steadyStateHypothesisVersion.namespaceRDF } </td>
                                             <td> { steadyStateHypothesisVersion.namespaceUML } </td>
                                             <td> { steadyStateHypothesisVersion.shortName } </td>
                                             <td>
                                                 <button onClick={ () => this.editSteadyStateHypothesisVersion(steadyStateHypothesisVersion.steadyStateHypothesisVersionId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSteadyStateHypothesisVersion(steadyStateHypothesisVersion.steadyStateHypothesisVersionId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSteadyStateHypothesisVersion(steadyStateHypothesisVersion.steadyStateHypothesisVersionId)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListSteadyStateHypothesisVersionComponent
