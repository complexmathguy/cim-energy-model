import React, { Component } from 'react'
import LoadResponseCharacteristicService from '../services/LoadResponseCharacteristicService'

class ListLoadResponseCharacteristicComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                loadResponseCharacteristics: []
        }
        this.addLoadResponseCharacteristic = this.addLoadResponseCharacteristic.bind(this);
        this.editLoadResponseCharacteristic = this.editLoadResponseCharacteristic.bind(this);
        this.deleteLoadResponseCharacteristic = this.deleteLoadResponseCharacteristic.bind(this);
    }

    deleteLoadResponseCharacteristic(id){
        LoadResponseCharacteristicService.deleteLoadResponseCharacteristic(id).then( res => {
            this.setState({loadResponseCharacteristics: this.state.loadResponseCharacteristics.filter(loadResponseCharacteristic => loadResponseCharacteristic.loadResponseCharacteristicId !== id)});
        });
    }
    viewLoadResponseCharacteristic(id){
        this.props.history.push(`/view-loadResponseCharacteristic/${id}`);
    }
    editLoadResponseCharacteristic(id){
        this.props.history.push(`/add-loadResponseCharacteristic/${id}`);
    }

    componentDidMount(){
        LoadResponseCharacteristicService.getLoadResponseCharacteristics().then((res) => {
            this.setState({ loadResponseCharacteristics: res.data});
        });
    }

    addLoadResponseCharacteristic(){
        this.props.history.push('/add-loadResponseCharacteristic/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">LoadResponseCharacteristic List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addLoadResponseCharacteristic}> Add LoadResponseCharacteristic</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> ExponentModel </th>
                                    <th> PConstantCurrent </th>
                                    <th> PConstantImpedance </th>
                                    <th> PConstantPower </th>
                                    <th> PFrequencyExponent </th>
                                    <th> PVoltageExponent </th>
                                    <th> QConstantCurrent </th>
                                    <th> QConstantImpedance </th>
                                    <th> QConstantPower </th>
                                    <th> QFrequencyExponent </th>
                                    <th> QVoltageExponent </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.loadResponseCharacteristics.map(
                                        loadResponseCharacteristic => 
                                        <tr key = {loadResponseCharacteristic.loadResponseCharacteristicId}>
                                             <td> { loadResponseCharacteristic.exponentModel } </td>
                                             <td> { loadResponseCharacteristic.pConstantCurrent } </td>
                                             <td> { loadResponseCharacteristic.pConstantImpedance } </td>
                                             <td> { loadResponseCharacteristic.pConstantPower } </td>
                                             <td> { loadResponseCharacteristic.pFrequencyExponent } </td>
                                             <td> { loadResponseCharacteristic.pVoltageExponent } </td>
                                             <td> { loadResponseCharacteristic.qConstantCurrent } </td>
                                             <td> { loadResponseCharacteristic.qConstantImpedance } </td>
                                             <td> { loadResponseCharacteristic.qConstantPower } </td>
                                             <td> { loadResponseCharacteristic.qFrequencyExponent } </td>
                                             <td> { loadResponseCharacteristic.qVoltageExponent } </td>
                                             <td>
                                                 <button onClick={ () => this.editLoadResponseCharacteristic(loadResponseCharacteristic.loadResponseCharacteristicId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteLoadResponseCharacteristic(loadResponseCharacteristic.loadResponseCharacteristicId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewLoadResponseCharacteristic(loadResponseCharacteristic.loadResponseCharacteristicId)} className="btn btn-info btn-sm">View </button>
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

export default ListLoadResponseCharacteristicComponent
