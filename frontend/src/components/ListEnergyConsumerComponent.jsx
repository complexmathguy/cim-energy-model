import React, { Component } from 'react'
import EnergyConsumerService from '../services/EnergyConsumerService'

class ListEnergyConsumerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                energyConsumers: []
        }
        this.addEnergyConsumer = this.addEnergyConsumer.bind(this);
        this.editEnergyConsumer = this.editEnergyConsumer.bind(this);
        this.deleteEnergyConsumer = this.deleteEnergyConsumer.bind(this);
    }

    deleteEnergyConsumer(id){
        EnergyConsumerService.deleteEnergyConsumer(id).then( res => {
            this.setState({energyConsumers: this.state.energyConsumers.filter(energyConsumer => energyConsumer.energyConsumerId !== id)});
        });
    }
    viewEnergyConsumer(id){
        this.props.history.push(`/view-energyConsumer/${id}`);
    }
    editEnergyConsumer(id){
        this.props.history.push(`/add-energyConsumer/${id}`);
    }

    componentDidMount(){
        EnergyConsumerService.getEnergyConsumers().then((res) => {
            this.setState({ energyConsumers: res.data});
        });
    }

    addEnergyConsumer(){
        this.props.history.push('/add-energyConsumer/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">EnergyConsumer List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addEnergyConsumer}> Add EnergyConsumer</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Pfixed </th>
                                    <th> PfixedPct </th>
                                    <th> Qfixed </th>
                                    <th> QfixedPct </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.energyConsumers.map(
                                        energyConsumer => 
                                        <tr key = {energyConsumer.energyConsumerId}>
                                             <td> { energyConsumer.pfixed } </td>
                                             <td> { energyConsumer.pfixedPct } </td>
                                             <td> { energyConsumer.qfixed } </td>
                                             <td> { energyConsumer.qfixedPct } </td>
                                             <td>
                                                 <button onClick={ () => this.editEnergyConsumer(energyConsumer.energyConsumerId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEnergyConsumer(energyConsumer.energyConsumerId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewEnergyConsumer(energyConsumer.energyConsumerId)} className="btn btn-info btn-sm">View </button>
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

export default ListEnergyConsumerComponent
