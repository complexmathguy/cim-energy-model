import React, { Component } from 'react'
import ApparentPowerLimitService from '../services/ApparentPowerLimitService'

class ListApparentPowerLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                apparentPowerLimits: []
        }
        this.addApparentPowerLimit = this.addApparentPowerLimit.bind(this);
        this.editApparentPowerLimit = this.editApparentPowerLimit.bind(this);
        this.deleteApparentPowerLimit = this.deleteApparentPowerLimit.bind(this);
    }

    deleteApparentPowerLimit(id){
        ApparentPowerLimitService.deleteApparentPowerLimit(id).then( res => {
            this.setState({apparentPowerLimits: this.state.apparentPowerLimits.filter(apparentPowerLimit => apparentPowerLimit.apparentPowerLimitId !== id)});
        });
    }
    viewApparentPowerLimit(id){
        this.props.history.push(`/view-apparentPowerLimit/${id}`);
    }
    editApparentPowerLimit(id){
        this.props.history.push(`/add-apparentPowerLimit/${id}`);
    }

    componentDidMount(){
        ApparentPowerLimitService.getApparentPowerLimits().then((res) => {
            this.setState({ apparentPowerLimits: res.data});
        });
    }

    addApparentPowerLimit(){
        this.props.history.push('/add-apparentPowerLimit/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ApparentPowerLimit List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addApparentPowerLimit}> Add ApparentPowerLimit</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.apparentPowerLimits.map(
                                        apparentPowerLimit => 
                                        <tr key = {apparentPowerLimit.apparentPowerLimitId}>
                                             <td> { apparentPowerLimit.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editApparentPowerLimit(apparentPowerLimit.apparentPowerLimitId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteApparentPowerLimit(apparentPowerLimit.apparentPowerLimitId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewApparentPowerLimit(apparentPowerLimit.apparentPowerLimitId)} className="btn btn-info btn-sm">View </button>
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

export default ListApparentPowerLimitComponent
