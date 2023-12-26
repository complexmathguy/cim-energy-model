import React, { Component } from 'react'
import VolumeFlowRateService from '../services/VolumeFlowRateService'

class ListVolumeFlowRateComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                volumeFlowRates: []
        }
        this.addVolumeFlowRate = this.addVolumeFlowRate.bind(this);
        this.editVolumeFlowRate = this.editVolumeFlowRate.bind(this);
        this.deleteVolumeFlowRate = this.deleteVolumeFlowRate.bind(this);
    }

    deleteVolumeFlowRate(id){
        VolumeFlowRateService.deleteVolumeFlowRate(id).then( res => {
            this.setState({volumeFlowRates: this.state.volumeFlowRates.filter(volumeFlowRate => volumeFlowRate.volumeFlowRateId !== id)});
        });
    }
    viewVolumeFlowRate(id){
        this.props.history.push(`/view-volumeFlowRate/${id}`);
    }
    editVolumeFlowRate(id){
        this.props.history.push(`/add-volumeFlowRate/${id}`);
    }

    componentDidMount(){
        VolumeFlowRateService.getVolumeFlowRates().then((res) => {
            this.setState({ volumeFlowRates: res.data});
        });
    }

    addVolumeFlowRate(){
        this.props.history.push('/add-volumeFlowRate/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">VolumeFlowRate List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addVolumeFlowRate}> Add VolumeFlowRate</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> DenominatorMultiplier </th>
                                    <th> DenominatorUnit </th>
                                    <th> Multiplier </th>
                                    <th> Unit </th>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.volumeFlowRates.map(
                                        volumeFlowRate => 
                                        <tr key = {volumeFlowRate.volumeFlowRateId}>
                                             <td> { volumeFlowRate.denominatorMultiplier } </td>
                                             <td> { volumeFlowRate.denominatorUnit } </td>
                                             <td> { volumeFlowRate.multiplier } </td>
                                             <td> { volumeFlowRate.unit } </td>
                                             <td> { volumeFlowRate.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editVolumeFlowRate(volumeFlowRate.volumeFlowRateId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteVolumeFlowRate(volumeFlowRate.volumeFlowRateId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewVolumeFlowRate(volumeFlowRate.volumeFlowRateId)} className="btn btn-info btn-sm">View </button>
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

export default ListVolumeFlowRateComponent
