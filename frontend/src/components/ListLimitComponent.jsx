import React, { Component } from 'react'
import LimitService from '../services/LimitService'

class ListLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                limits: []
        }
        this.addLimit = this.addLimit.bind(this);
        this.editLimit = this.editLimit.bind(this);
        this.deleteLimit = this.deleteLimit.bind(this);
    }

    deleteLimit(id){
        LimitService.deleteLimit(id).then( res => {
            this.setState({limits: this.state.limits.filter(limit => limit.limitId !== id)});
        });
    }
    viewLimit(id){
        this.props.history.push(`/view-limit/${id}`);
    }
    editLimit(id){
        this.props.history.push(`/add-limit/${id}`);
    }

    componentDidMount(){
        LimitService.getLimits().then((res) => {
            this.setState({ limits: res.data});
        });
    }

    addLimit(){
        this.props.history.push('/add-limit/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Limit List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addLimit}> Add Limit</button>
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
                                    this.state.limits.map(
                                        limit => 
                                        <tr key = {limit.limitId}>
                                             <td>
                                                 <button onClick={ () => this.editLimit(limit.limitId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteLimit(limit.limitId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewLimit(limit.limitId)} className="btn btn-info btn-sm">View </button>
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

export default ListLimitComponent
