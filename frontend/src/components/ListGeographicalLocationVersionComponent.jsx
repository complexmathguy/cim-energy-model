import React, { Component } from 'react'
import GeographicalLocationVersionService from '../services/GeographicalLocationVersionService'

class ListGeographicalLocationVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                geographicalLocationVersions: []
        }
        this.addGeographicalLocationVersion = this.addGeographicalLocationVersion.bind(this);
        this.editGeographicalLocationVersion = this.editGeographicalLocationVersion.bind(this);
        this.deleteGeographicalLocationVersion = this.deleteGeographicalLocationVersion.bind(this);
    }

    deleteGeographicalLocationVersion(id){
        GeographicalLocationVersionService.deleteGeographicalLocationVersion(id).then( res => {
            this.setState({geographicalLocationVersions: this.state.geographicalLocationVersions.filter(geographicalLocationVersion => geographicalLocationVersion.geographicalLocationVersionId !== id)});
        });
    }
    viewGeographicalLocationVersion(id){
        this.props.history.push(`/view-geographicalLocationVersion/${id}`);
    }
    editGeographicalLocationVersion(id){
        this.props.history.push(`/add-geographicalLocationVersion/${id}`);
    }

    componentDidMount(){
        GeographicalLocationVersionService.getGeographicalLocationVersions().then((res) => {
            this.setState({ geographicalLocationVersions: res.data});
        });
    }

    addGeographicalLocationVersion(){
        this.props.history.push('/add-geographicalLocationVersion/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GeographicalLocationVersion List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGeographicalLocationVersion}> Add GeographicalLocationVersion</button>
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
                                    this.state.geographicalLocationVersions.map(
                                        geographicalLocationVersion => 
                                        <tr key = {geographicalLocationVersion.geographicalLocationVersionId}>
                                             <td> { geographicalLocationVersion.baseUML } </td>
                                             <td> { geographicalLocationVersion.baseURI } </td>
                                             <td> { geographicalLocationVersion.date } </td>
                                             <td> { geographicalLocationVersion.differenceModelURI } </td>
                                             <td> { geographicalLocationVersion.entsoeUML } </td>
                                             <td> { geographicalLocationVersion.entsoeURI } </td>
                                             <td> { geographicalLocationVersion.modelDescriptionURI } </td>
                                             <td> { geographicalLocationVersion.namespaceRDF } </td>
                                             <td> { geographicalLocationVersion.namespaceUML } </td>
                                             <td> { geographicalLocationVersion.shortName } </td>
                                             <td>
                                                 <button onClick={ () => this.editGeographicalLocationVersion(geographicalLocationVersion.geographicalLocationVersionId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGeographicalLocationVersion(geographicalLocationVersion.geographicalLocationVersionId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGeographicalLocationVersion(geographicalLocationVersion.geographicalLocationVersionId)} className="btn btn-info btn-sm">View </button>
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

export default ListGeographicalLocationVersionComponent
