import React, { Component } from 'react'
import EnergyAreaService from '../services/EnergyAreaService'

class ListEnergyAreaComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                energyAreas: []
        }
        this.addEnergyArea = this.addEnergyArea.bind(this);
        this.editEnergyArea = this.editEnergyArea.bind(this);
        this.deleteEnergyArea = this.deleteEnergyArea.bind(this);
    }

    deleteEnergyArea(id){
        EnergyAreaService.deleteEnergyArea(id).then( res => {
            this.setState({energyAreas: this.state.energyAreas.filter(energyArea => energyArea.energyAreaId !== id)});
        });
    }
    viewEnergyArea(id){
        this.props.history.push(`/view-energyArea/${id}`);
    }
    editEnergyArea(id){
        this.props.history.push(`/add-energyArea/${id}`);
    }

    componentDidMount(){
        EnergyAreaService.getEnergyAreas().then((res) => {
            this.setState({ energyAreas: res.data});
        });
    }

    addEnergyArea(){
        this.props.history.push('/add-energyArea/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">EnergyArea List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addEnergyArea}> Add EnergyArea</button>
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
                                    this.state.energyAreas.map(
                                        energyArea => 
                                        <tr key = {energyArea.energyAreaId}>
                                             <td>
                                                 <button onClick={ () => this.editEnergyArea(energyArea.energyAreaId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEnergyArea(energyArea.energyAreaId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewEnergyArea(energyArea.energyAreaId)} className="btn btn-info btn-sm">View </button>
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

export default ListEnergyAreaComponent
