import React, { Component } from 'react'
import SynchronousMachineDetailedService from '../services/SynchronousMachineDetailedService'

class ListSynchronousMachineDetailedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                synchronousMachineDetaileds: []
        }
        this.addSynchronousMachineDetailed = this.addSynchronousMachineDetailed.bind(this);
        this.editSynchronousMachineDetailed = this.editSynchronousMachineDetailed.bind(this);
        this.deleteSynchronousMachineDetailed = this.deleteSynchronousMachineDetailed.bind(this);
    }

    deleteSynchronousMachineDetailed(id){
        SynchronousMachineDetailedService.deleteSynchronousMachineDetailed(id).then( res => {
            this.setState({synchronousMachineDetaileds: this.state.synchronousMachineDetaileds.filter(synchronousMachineDetailed => synchronousMachineDetailed.synchronousMachineDetailedId !== id)});
        });
    }
    viewSynchronousMachineDetailed(id){
        this.props.history.push(`/view-synchronousMachineDetailed/${id}`);
    }
    editSynchronousMachineDetailed(id){
        this.props.history.push(`/add-synchronousMachineDetailed/${id}`);
    }

    componentDidMount(){
        SynchronousMachineDetailedService.getSynchronousMachineDetaileds().then((res) => {
            this.setState({ synchronousMachineDetaileds: res.data});
        });
    }

    addSynchronousMachineDetailed(){
        this.props.history.push('/add-synchronousMachineDetailed/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SynchronousMachineDetailed List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSynchronousMachineDetailed}> Add SynchronousMachineDetailed</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> EfdBaseRatio </th>
                                    <th> IfdBaseType </th>
                                    <th> IfdBaseValue </th>
                                    <th> SaturationFactor120QAxis </th>
                                    <th> SaturationFactorQAxis </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.synchronousMachineDetaileds.map(
                                        synchronousMachineDetailed => 
                                        <tr key = {synchronousMachineDetailed.synchronousMachineDetailedId}>
                                             <td> { synchronousMachineDetailed.efdBaseRatio } </td>
                                             <td> { synchronousMachineDetailed.ifdBaseType } </td>
                                             <td> { synchronousMachineDetailed.ifdBaseValue } </td>
                                             <td> { synchronousMachineDetailed.saturationFactor120QAxis } </td>
                                             <td> { synchronousMachineDetailed.saturationFactorQAxis } </td>
                                             <td>
                                                 <button onClick={ () => this.editSynchronousMachineDetailed(synchronousMachineDetailed.synchronousMachineDetailedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSynchronousMachineDetailed(synchronousMachineDetailed.synchronousMachineDetailedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSynchronousMachineDetailed(synchronousMachineDetailed.synchronousMachineDetailedId)} className="btn btn-info btn-sm">View </button>
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

export default ListSynchronousMachineDetailedComponent
