import React, { Component } from 'react'
import ReactivePowerService from '../services/ReactivePowerService'

class ListReactivePowerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                reactivePowers: []
        }
        this.addReactivePower = this.addReactivePower.bind(this);
        this.editReactivePower = this.editReactivePower.bind(this);
        this.deleteReactivePower = this.deleteReactivePower.bind(this);
    }

    deleteReactivePower(id){
        ReactivePowerService.deleteReactivePower(id).then( res => {
            this.setState({reactivePowers: this.state.reactivePowers.filter(reactivePower => reactivePower.reactivePowerId !== id)});
        });
    }
    viewReactivePower(id){
        this.props.history.push(`/view-reactivePower/${id}`);
    }
    editReactivePower(id){
        this.props.history.push(`/add-reactivePower/${id}`);
    }

    componentDidMount(){
        ReactivePowerService.getReactivePowers().then((res) => {
            this.setState({ reactivePowers: res.data});
        });
    }

    addReactivePower(){
        this.props.history.push('/add-reactivePower/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ReactivePower List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addReactivePower}> Add ReactivePower</button>
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
                                    this.state.reactivePowers.map(
                                        reactivePower => 
                                        <tr key = {reactivePower.reactivePowerId}>
                                             <td> { reactivePower.multiplier } </td>
                                             <td> { reactivePower.unit } </td>
                                             <td> { reactivePower.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editReactivePower(reactivePower.reactivePowerId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteReactivePower(reactivePower.reactivePowerId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewReactivePower(reactivePower.reactivePowerId)} className="btn btn-info btn-sm">View </button>
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

export default ListReactivePowerComponent
