import React, { Component } from 'react'
import DCSeriesDeviceService from '../services/DCSeriesDeviceService'

class ListDCSeriesDeviceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dCSeriesDevices: []
        }
        this.addDCSeriesDevice = this.addDCSeriesDevice.bind(this);
        this.editDCSeriesDevice = this.editDCSeriesDevice.bind(this);
        this.deleteDCSeriesDevice = this.deleteDCSeriesDevice.bind(this);
    }

    deleteDCSeriesDevice(id){
        DCSeriesDeviceService.deleteDCSeriesDevice(id).then( res => {
            this.setState({dCSeriesDevices: this.state.dCSeriesDevices.filter(dCSeriesDevice => dCSeriesDevice.dCSeriesDeviceId !== id)});
        });
    }
    viewDCSeriesDevice(id){
        this.props.history.push(`/view-dCSeriesDevice/${id}`);
    }
    editDCSeriesDevice(id){
        this.props.history.push(`/add-dCSeriesDevice/${id}`);
    }

    componentDidMount(){
        DCSeriesDeviceService.getDCSeriesDevices().then((res) => {
            this.setState({ dCSeriesDevices: res.data});
        });
    }

    addDCSeriesDevice(){
        this.props.history.push('/add-dCSeriesDevice/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DCSeriesDevice List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDCSeriesDevice}> Add DCSeriesDevice</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Inductance </th>
                                    <th> RatedUdc </th>
                                    <th> Resistance </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.dCSeriesDevices.map(
                                        dCSeriesDevice => 
                                        <tr key = {dCSeriesDevice.dCSeriesDeviceId}>
                                             <td> { dCSeriesDevice.inductance } </td>
                                             <td> { dCSeriesDevice.ratedUdc } </td>
                                             <td> { dCSeriesDevice.resistance } </td>
                                             <td>
                                                 <button onClick={ () => this.editDCSeriesDevice(dCSeriesDevice.dCSeriesDeviceId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDCSeriesDevice(dCSeriesDevice.dCSeriesDeviceId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDCSeriesDevice(dCSeriesDevice.dCSeriesDeviceId)} className="btn btn-info btn-sm">View </button>
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

export default ListDCSeriesDeviceComponent
