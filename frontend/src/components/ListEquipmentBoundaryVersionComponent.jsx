import React, { Component } from 'react'
import EquipmentBoundaryVersionService from '../services/EquipmentBoundaryVersionService'

class ListEquipmentBoundaryVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                equipmentBoundaryVersions: []
        }
        this.addEquipmentBoundaryVersion = this.addEquipmentBoundaryVersion.bind(this);
        this.editEquipmentBoundaryVersion = this.editEquipmentBoundaryVersion.bind(this);
        this.deleteEquipmentBoundaryVersion = this.deleteEquipmentBoundaryVersion.bind(this);
    }

    deleteEquipmentBoundaryVersion(id){
        EquipmentBoundaryVersionService.deleteEquipmentBoundaryVersion(id).then( res => {
            this.setState({equipmentBoundaryVersions: this.state.equipmentBoundaryVersions.filter(equipmentBoundaryVersion => equipmentBoundaryVersion.equipmentBoundaryVersionId !== id)});
        });
    }
    viewEquipmentBoundaryVersion(id){
        this.props.history.push(`/view-equipmentBoundaryVersion/${id}`);
    }
    editEquipmentBoundaryVersion(id){
        this.props.history.push(`/add-equipmentBoundaryVersion/${id}`);
    }

    componentDidMount(){
        EquipmentBoundaryVersionService.getEquipmentBoundaryVersions().then((res) => {
            this.setState({ equipmentBoundaryVersions: res.data});
        });
    }

    addEquipmentBoundaryVersion(){
        this.props.history.push('/add-equipmentBoundaryVersion/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">EquipmentBoundaryVersion List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addEquipmentBoundaryVersion}> Add EquipmentBoundaryVersion</button>
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
                                    <th> EntsoeURIcore </th>
                                    <th> EntsoeURIoperation </th>
                                    <th> ModelDescriptionURI </th>
                                    <th> NamespaceRDF </th>
                                    <th> NamespaceUML </th>
                                    <th> ShortName </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.equipmentBoundaryVersions.map(
                                        equipmentBoundaryVersion => 
                                        <tr key = {equipmentBoundaryVersion.equipmentBoundaryVersionId}>
                                             <td> { equipmentBoundaryVersion.baseUML } </td>
                                             <td> { equipmentBoundaryVersion.baseURI } </td>
                                             <td> { equipmentBoundaryVersion.date } </td>
                                             <td> { equipmentBoundaryVersion.differenceModelURI } </td>
                                             <td> { equipmentBoundaryVersion.entsoeUML } </td>
                                             <td> { equipmentBoundaryVersion.entsoeURIcore } </td>
                                             <td> { equipmentBoundaryVersion.entsoeURIoperation } </td>
                                             <td> { equipmentBoundaryVersion.modelDescriptionURI } </td>
                                             <td> { equipmentBoundaryVersion.namespaceRDF } </td>
                                             <td> { equipmentBoundaryVersion.namespaceUML } </td>
                                             <td> { equipmentBoundaryVersion.shortName } </td>
                                             <td>
                                                 <button onClick={ () => this.editEquipmentBoundaryVersion(equipmentBoundaryVersion.equipmentBoundaryVersionId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEquipmentBoundaryVersion(equipmentBoundaryVersion.equipmentBoundaryVersionId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewEquipmentBoundaryVersion(equipmentBoundaryVersion.equipmentBoundaryVersionId)} className="btn btn-info btn-sm">View </button>
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

export default ListEquipmentBoundaryVersionComponent
