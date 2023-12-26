import React, { Component } from 'react'
import ApparentPowerService from '../services/ApparentPowerService'

class ListApparentPowerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                apparentPowers: []
        }
        this.addApparentPower = this.addApparentPower.bind(this);
        this.editApparentPower = this.editApparentPower.bind(this);
        this.deleteApparentPower = this.deleteApparentPower.bind(this);
    }

    deleteApparentPower(id){
        ApparentPowerService.deleteApparentPower(id).then( res => {
            this.setState({apparentPowers: this.state.apparentPowers.filter(apparentPower => apparentPower.apparentPowerId !== id)});
        });
    }
    viewApparentPower(id){
        this.props.history.push(`/view-apparentPower/${id}`);
    }
    editApparentPower(id){
        this.props.history.push(`/add-apparentPower/${id}`);
    }

    componentDidMount(){
        ApparentPowerService.getApparentPowers().then((res) => {
            this.setState({ apparentPowers: res.data});
        });
    }

    addApparentPower(){
        this.props.history.push('/add-apparentPower/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ApparentPower List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addApparentPower}> Add ApparentPower</button>
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
                                    this.state.apparentPowers.map(
                                        apparentPower => 
                                        <tr key = {apparentPower.apparentPowerId}>
                                             <td> { apparentPower.multiplier } </td>
                                             <td> { apparentPower.unit } </td>
                                             <td> { apparentPower.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editApparentPower(apparentPower.apparentPowerId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteApparentPower(apparentPower.apparentPowerId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewApparentPower(apparentPower.apparentPowerId)} className="btn btn-info btn-sm">View </button>
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

export default ListApparentPowerComponent
