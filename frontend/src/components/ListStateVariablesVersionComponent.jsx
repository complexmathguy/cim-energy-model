import React, { Component } from 'react'
import StateVariablesVersionService from '../services/StateVariablesVersionService'

class ListStateVariablesVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                stateVariablesVersions: []
        }
        this.addStateVariablesVersion = this.addStateVariablesVersion.bind(this);
        this.editStateVariablesVersion = this.editStateVariablesVersion.bind(this);
        this.deleteStateVariablesVersion = this.deleteStateVariablesVersion.bind(this);
    }

    deleteStateVariablesVersion(id){
        StateVariablesVersionService.deleteStateVariablesVersion(id).then( res => {
            this.setState({stateVariablesVersions: this.state.stateVariablesVersions.filter(stateVariablesVersion => stateVariablesVersion.stateVariablesVersionId !== id)});
        });
    }
    viewStateVariablesVersion(id){
        this.props.history.push(`/view-stateVariablesVersion/${id}`);
    }
    editStateVariablesVersion(id){
        this.props.history.push(`/add-stateVariablesVersion/${id}`);
    }

    componentDidMount(){
        StateVariablesVersionService.getStateVariablesVersions().then((res) => {
            this.setState({ stateVariablesVersions: res.data});
        });
    }

    addStateVariablesVersion(){
        this.props.history.push('/add-stateVariablesVersion/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">StateVariablesVersion List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addStateVariablesVersion}> Add StateVariablesVersion</button>
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
                                    this.state.stateVariablesVersions.map(
                                        stateVariablesVersion => 
                                        <tr key = {stateVariablesVersion.stateVariablesVersionId}>
                                             <td> { stateVariablesVersion.baseUML } </td>
                                             <td> { stateVariablesVersion.baseURI } </td>
                                             <td> { stateVariablesVersion.date } </td>
                                             <td> { stateVariablesVersion.differenceModelURI } </td>
                                             <td> { stateVariablesVersion.entsoeUML } </td>
                                             <td> { stateVariablesVersion.entsoeURI } </td>
                                             <td> { stateVariablesVersion.modelDescriptionURI } </td>
                                             <td> { stateVariablesVersion.namespaceRDF } </td>
                                             <td> { stateVariablesVersion.namespaceUML } </td>
                                             <td> { stateVariablesVersion.shortName } </td>
                                             <td>
                                                 <button onClick={ () => this.editStateVariablesVersion(stateVariablesVersion.stateVariablesVersionId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteStateVariablesVersion(stateVariablesVersion.stateVariablesVersionId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewStateVariablesVersion(stateVariablesVersion.stateVariablesVersionId)} className="btn btn-info btn-sm">View </button>
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

export default ListStateVariablesVersionComponent
