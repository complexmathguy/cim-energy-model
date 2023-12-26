import React, { Component } from 'react'
import EquipmentContainerService from '../services/EquipmentContainerService'

class ListEquipmentContainerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                equipmentContainers: []
        }
        this.addEquipmentContainer = this.addEquipmentContainer.bind(this);
        this.editEquipmentContainer = this.editEquipmentContainer.bind(this);
        this.deleteEquipmentContainer = this.deleteEquipmentContainer.bind(this);
    }

    deleteEquipmentContainer(id){
        EquipmentContainerService.deleteEquipmentContainer(id).then( res => {
            this.setState({equipmentContainers: this.state.equipmentContainers.filter(equipmentContainer => equipmentContainer.equipmentContainerId !== id)});
        });
    }
    viewEquipmentContainer(id){
        this.props.history.push(`/view-equipmentContainer/${id}`);
    }
    editEquipmentContainer(id){
        this.props.history.push(`/add-equipmentContainer/${id}`);
    }

    componentDidMount(){
        EquipmentContainerService.getEquipmentContainers().then((res) => {
            this.setState({ equipmentContainers: res.data});
        });
    }

    addEquipmentContainer(){
        this.props.history.push('/add-equipmentContainer/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">EquipmentContainer List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addEquipmentContainer}> Add EquipmentContainer</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.equipmentContainers.map(
                                        equipmentContainer => 
                                        <tr key = {equipmentContainer.equipmentContainerId}>
                                             <td>
                                                 <button onClick={ () => this.editEquipmentContainer(equipmentContainer.equipmentContainerId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEquipmentContainer(equipmentContainer.equipmentContainerId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewEquipmentContainer(equipmentContainer.equipmentContainerId)} className="btn btn-info btn-sm">View </button>
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

export default ListEquipmentContainerComponent
