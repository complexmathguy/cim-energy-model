import React, { Component } from 'react'
import TemperatureService from '../services/TemperatureService'

class ListTemperatureComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                temperatures: []
        }
        this.addTemperature = this.addTemperature.bind(this);
        this.editTemperature = this.editTemperature.bind(this);
        this.deleteTemperature = this.deleteTemperature.bind(this);
    }

    deleteTemperature(id){
        TemperatureService.deleteTemperature(id).then( res => {
            this.setState({temperatures: this.state.temperatures.filter(temperature => temperature.temperatureId !== id)});
        });
    }
    viewTemperature(id){
        this.props.history.push(`/view-temperature/${id}`);
    }
    editTemperature(id){
        this.props.history.push(`/add-temperature/${id}`);
    }

    componentDidMount(){
        TemperatureService.getTemperatures().then((res) => {
            this.setState({ temperatures: res.data});
        });
    }

    addTemperature(){
        this.props.history.push('/add-temperature/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Temperature List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addTemperature}> Add Temperature</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Multiplier </th>
                                    <th> Unit </th>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.temperatures.map(
                                        temperature => 
                                        <tr key = {temperature.temperatureId}>
                                             <td> { temperature.multiplier } </td>
                                             <td> { temperature.unit } </td>
                                             <td> { temperature.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editTemperature(temperature.temperatureId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteTemperature(temperature.temperatureId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewTemperature(temperature.temperatureId)} className="btn btn-info btn-sm">View </button>
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

export default ListTemperatureComponent
