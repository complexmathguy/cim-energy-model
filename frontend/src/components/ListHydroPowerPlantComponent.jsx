import React, { Component } from 'react'
import HydroPowerPlantService from '../services/HydroPowerPlantService'

class ListHydroPowerPlantComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                hydroPowerPlants: []
        }
        this.addHydroPowerPlant = this.addHydroPowerPlant.bind(this);
        this.editHydroPowerPlant = this.editHydroPowerPlant.bind(this);
        this.deleteHydroPowerPlant = this.deleteHydroPowerPlant.bind(this);
    }

    deleteHydroPowerPlant(id){
        HydroPowerPlantService.deleteHydroPowerPlant(id).then( res => {
            this.setState({hydroPowerPlants: this.state.hydroPowerPlants.filter(hydroPowerPlant => hydroPowerPlant.hydroPowerPlantId !== id)});
        });
    }
    viewHydroPowerPlant(id){
        this.props.history.push(`/view-hydroPowerPlant/${id}`);
    }
    editHydroPowerPlant(id){
        this.props.history.push(`/add-hydroPowerPlant/${id}`);
    }

    componentDidMount(){
        HydroPowerPlantService.getHydroPowerPlants().then((res) => {
            this.setState({ hydroPowerPlants: res.data});
        });
    }

    addHydroPowerPlant(){
        this.props.history.push('/add-hydroPowerPlant/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">HydroPowerPlant List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addHydroPowerPlant}> Add HydroPowerPlant</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> HydroPlantStorageType </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.hydroPowerPlants.map(
                                        hydroPowerPlant => 
                                        <tr key = {hydroPowerPlant.hydroPowerPlantId}>
                                             <td> { hydroPowerPlant.hydroPlantStorageType } </td>
                                             <td>
                                                 <button onClick={ () => this.editHydroPowerPlant(hydroPowerPlant.hydroPowerPlantId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteHydroPowerPlant(hydroPowerPlant.hydroPowerPlantId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewHydroPowerPlant(hydroPowerPlant.hydroPowerPlantId)} className="btn btn-info btn-sm">View </button>
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

export default ListHydroPowerPlantComponent
