import React, { Component } from 'react'
import EnergySourceService from '../services/EnergySourceService'

class ListEnergySourceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                energySources: []
        }
        this.addEnergySource = this.addEnergySource.bind(this);
        this.editEnergySource = this.editEnergySource.bind(this);
        this.deleteEnergySource = this.deleteEnergySource.bind(this);
    }

    deleteEnergySource(id){
        EnergySourceService.deleteEnergySource(id).then( res => {
            this.setState({energySources: this.state.energySources.filter(energySource => energySource.energySourceId !== id)});
        });
    }
    viewEnergySource(id){
        this.props.history.push(`/view-energySource/${id}`);
    }
    editEnergySource(id){
        this.props.history.push(`/add-energySource/${id}`);
    }

    componentDidMount(){
        EnergySourceService.getEnergySources().then((res) => {
            this.setState({ energySources: res.data});
        });
    }

    addEnergySource(){
        this.props.history.push('/add-energySource/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">EnergySource List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addEnergySource}> Add EnergySource</button>
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
                                    this.state.energySources.map(
                                        energySource => 
                                        <tr key = {energySource.energySourceId}>
                                             <td>
                                                 <button onClick={ () => this.editEnergySource(energySource.energySourceId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEnergySource(energySource.energySourceId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewEnergySource(energySource.energySourceId)} className="btn btn-info btn-sm">View </button>
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

export default ListEnergySourceComponent
