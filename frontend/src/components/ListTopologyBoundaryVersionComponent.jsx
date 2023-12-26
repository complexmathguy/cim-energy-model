import React, { Component } from 'react'
import TopologyBoundaryVersionService from '../services/TopologyBoundaryVersionService'

class ListTopologyBoundaryVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                topologyBoundaryVersions: []
        }
        this.addTopologyBoundaryVersion = this.addTopologyBoundaryVersion.bind(this);
        this.editTopologyBoundaryVersion = this.editTopologyBoundaryVersion.bind(this);
        this.deleteTopologyBoundaryVersion = this.deleteTopologyBoundaryVersion.bind(this);
    }

    deleteTopologyBoundaryVersion(id){
        TopologyBoundaryVersionService.deleteTopologyBoundaryVersion(id).then( res => {
            this.setState({topologyBoundaryVersions: this.state.topologyBoundaryVersions.filter(topologyBoundaryVersion => topologyBoundaryVersion.topologyBoundaryVersionId !== id)});
        });
    }
    viewTopologyBoundaryVersion(id){
        this.props.history.push(`/view-topologyBoundaryVersion/${id}`);
    }
    editTopologyBoundaryVersion(id){
        this.props.history.push(`/add-topologyBoundaryVersion/${id}`);
    }

    componentDidMount(){
        TopologyBoundaryVersionService.getTopologyBoundaryVersions().then((res) => {
            this.setState({ topologyBoundaryVersions: res.data});
        });
    }

    addTopologyBoundaryVersion(){
        this.props.history.push('/add-topologyBoundaryVersion/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">TopologyBoundaryVersion List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addTopologyBoundaryVersion}> Add TopologyBoundaryVersion</button>
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
                                    this.state.topologyBoundaryVersions.map(
                                        topologyBoundaryVersion => 
                                        <tr key = {topologyBoundaryVersion.topologyBoundaryVersionId}>
                                             <td> { topologyBoundaryVersion.baseUML } </td>
                                             <td> { topologyBoundaryVersion.baseURI } </td>
                                             <td> { topologyBoundaryVersion.date } </td>
                                             <td> { topologyBoundaryVersion.differenceModelURI } </td>
                                             <td> { topologyBoundaryVersion.entsoeUML } </td>
                                             <td> { topologyBoundaryVersion.entsoeURI } </td>
                                             <td> { topologyBoundaryVersion.modelDescriptionURI } </td>
                                             <td> { topologyBoundaryVersion.namespaceRDF } </td>
                                             <td> { topologyBoundaryVersion.namespaceUML } </td>
                                             <td> { topologyBoundaryVersion.shortName } </td>
                                             <td>
                                                 <button onClick={ () => this.editTopologyBoundaryVersion(topologyBoundaryVersion.topologyBoundaryVersionId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteTopologyBoundaryVersion(topologyBoundaryVersion.topologyBoundaryVersionId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewTopologyBoundaryVersion(topologyBoundaryVersion.topologyBoundaryVersionId)} className="btn btn-info btn-sm">View </button>
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

export default ListTopologyBoundaryVersionComponent
