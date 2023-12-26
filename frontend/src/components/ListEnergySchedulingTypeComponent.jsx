import React, { Component } from 'react'
import EnergySchedulingTypeService from '../services/EnergySchedulingTypeService'

class ListEnergySchedulingTypeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                energySchedulingTypes: []
        }
        this.addEnergySchedulingType = this.addEnergySchedulingType.bind(this);
        this.editEnergySchedulingType = this.editEnergySchedulingType.bind(this);
        this.deleteEnergySchedulingType = this.deleteEnergySchedulingType.bind(this);
    }

    deleteEnergySchedulingType(id){
        EnergySchedulingTypeService.deleteEnergySchedulingType(id).then( res => {
            this.setState({energySchedulingTypes: this.state.energySchedulingTypes.filter(energySchedulingType => energySchedulingType.energySchedulingTypeId !== id)});
        });
    }
    viewEnergySchedulingType(id){
        this.props.history.push(`/view-energySchedulingType/${id}`);
    }
    editEnergySchedulingType(id){
        this.props.history.push(`/add-energySchedulingType/${id}`);
    }

    componentDidMount(){
        EnergySchedulingTypeService.getEnergySchedulingTypes().then((res) => {
            this.setState({ energySchedulingTypes: res.data});
        });
    }

    addEnergySchedulingType(){
        this.props.history.push('/add-energySchedulingType/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">EnergySchedulingType List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addEnergySchedulingType}> Add EnergySchedulingType</button>
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
                                    this.state.energySchedulingTypes.map(
                                        energySchedulingType => 
                                        <tr key = {energySchedulingType.energySchedulingTypeId}>
                                             <td>
                                                 <button onClick={ () => this.editEnergySchedulingType(energySchedulingType.energySchedulingTypeId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEnergySchedulingType(energySchedulingType.energySchedulingTypeId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewEnergySchedulingType(energySchedulingType.energySchedulingTypeId)} className="btn btn-info btn-sm">View </button>
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

export default ListEnergySchedulingTypeComponent
