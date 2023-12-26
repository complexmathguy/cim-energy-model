import React, { Component } from 'react'
import DynamicsVersionService from '../services/DynamicsVersionService'

class ListDynamicsVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dynamicsVersions: []
        }
        this.addDynamicsVersion = this.addDynamicsVersion.bind(this);
        this.editDynamicsVersion = this.editDynamicsVersion.bind(this);
        this.deleteDynamicsVersion = this.deleteDynamicsVersion.bind(this);
    }

    deleteDynamicsVersion(id){
        DynamicsVersionService.deleteDynamicsVersion(id).then( res => {
            this.setState({dynamicsVersions: this.state.dynamicsVersions.filter(dynamicsVersion => dynamicsVersion.dynamicsVersionId !== id)});
        });
    }
    viewDynamicsVersion(id){
        this.props.history.push(`/view-dynamicsVersion/${id}`);
    }
    editDynamicsVersion(id){
        this.props.history.push(`/add-dynamicsVersion/${id}`);
    }

    componentDidMount(){
        DynamicsVersionService.getDynamicsVersions().then((res) => {
            this.setState({ dynamicsVersions: res.data});
        });
    }

    addDynamicsVersion(){
        this.props.history.push('/add-dynamicsVersion/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DynamicsVersion List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDynamicsVersion}> Add DynamicsVersion</button>
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
                                    this.state.dynamicsVersions.map(
                                        dynamicsVersion => 
                                        <tr key = {dynamicsVersion.dynamicsVersionId}>
                                             <td> { dynamicsVersion.baseUML } </td>
                                             <td> { dynamicsVersion.baseURI } </td>
                                             <td> { dynamicsVersion.date } </td>
                                             <td> { dynamicsVersion.differenceModelURI } </td>
                                             <td> { dynamicsVersion.entsoeUML } </td>
                                             <td> { dynamicsVersion.entsoeURI } </td>
                                             <td> { dynamicsVersion.modelDescriptionURI } </td>
                                             <td> { dynamicsVersion.namespaceRDF } </td>
                                             <td> { dynamicsVersion.namespaceUML } </td>
                                             <td> { dynamicsVersion.shortName } </td>
                                             <td>
                                                 <button onClick={ () => this.editDynamicsVersion(dynamicsVersion.dynamicsVersionId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDynamicsVersion(dynamicsVersion.dynamicsVersionId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDynamicsVersion(dynamicsVersion.dynamicsVersionId)} className="btn btn-info btn-sm">View </button>
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

export default ListDynamicsVersionComponent
