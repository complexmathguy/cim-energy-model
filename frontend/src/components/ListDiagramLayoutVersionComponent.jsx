import React, { Component } from 'react'
import DiagramLayoutVersionService from '../services/DiagramLayoutVersionService'

class ListDiagramLayoutVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                diagramLayoutVersions: []
        }
        this.addDiagramLayoutVersion = this.addDiagramLayoutVersion.bind(this);
        this.editDiagramLayoutVersion = this.editDiagramLayoutVersion.bind(this);
        this.deleteDiagramLayoutVersion = this.deleteDiagramLayoutVersion.bind(this);
    }

    deleteDiagramLayoutVersion(id){
        DiagramLayoutVersionService.deleteDiagramLayoutVersion(id).then( res => {
            this.setState({diagramLayoutVersions: this.state.diagramLayoutVersions.filter(diagramLayoutVersion => diagramLayoutVersion.diagramLayoutVersionId !== id)});
        });
    }
    viewDiagramLayoutVersion(id){
        this.props.history.push(`/view-diagramLayoutVersion/${id}`);
    }
    editDiagramLayoutVersion(id){
        this.props.history.push(`/add-diagramLayoutVersion/${id}`);
    }

    componentDidMount(){
        DiagramLayoutVersionService.getDiagramLayoutVersions().then((res) => {
            this.setState({ diagramLayoutVersions: res.data});
        });
    }

    addDiagramLayoutVersion(){
        this.props.history.push('/add-diagramLayoutVersion/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DiagramLayoutVersion List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDiagramLayoutVersion}> Add DiagramLayoutVersion</button>
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
                                    this.state.diagramLayoutVersions.map(
                                        diagramLayoutVersion => 
                                        <tr key = {diagramLayoutVersion.diagramLayoutVersionId}>
                                             <td> { diagramLayoutVersion.baseUML } </td>
                                             <td> { diagramLayoutVersion.baseURI } </td>
                                             <td> { diagramLayoutVersion.date } </td>
                                             <td> { diagramLayoutVersion.differenceModelURI } </td>
                                             <td> { diagramLayoutVersion.entsoeUML } </td>
                                             <td> { diagramLayoutVersion.entsoeURI } </td>
                                             <td> { diagramLayoutVersion.modelDescriptionURI } </td>
                                             <td> { diagramLayoutVersion.namespaceRDF } </td>
                                             <td> { diagramLayoutVersion.namespaceUML } </td>
                                             <td> { diagramLayoutVersion.shortName } </td>
                                             <td>
                                                 <button onClick={ () => this.editDiagramLayoutVersion(diagramLayoutVersion.diagramLayoutVersionId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDiagramLayoutVersion(diagramLayoutVersion.diagramLayoutVersionId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDiagramLayoutVersion(diagramLayoutVersion.diagramLayoutVersionId)} className="btn btn-info btn-sm">View </button>
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

export default ListDiagramLayoutVersionComponent
