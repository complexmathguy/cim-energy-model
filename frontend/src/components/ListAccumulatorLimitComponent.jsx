import React, { Component } from 'react'
import AccumulatorLimitService from '../services/AccumulatorLimitService'

class ListAccumulatorLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                accumulatorLimits: []
        }
        this.addAccumulatorLimit = this.addAccumulatorLimit.bind(this);
        this.editAccumulatorLimit = this.editAccumulatorLimit.bind(this);
        this.deleteAccumulatorLimit = this.deleteAccumulatorLimit.bind(this);
    }

    deleteAccumulatorLimit(id){
        AccumulatorLimitService.deleteAccumulatorLimit(id).then( res => {
            this.setState({accumulatorLimits: this.state.accumulatorLimits.filter(accumulatorLimit => accumulatorLimit.accumulatorLimitId !== id)});
        });
    }
    viewAccumulatorLimit(id){
        this.props.history.push(`/view-accumulatorLimit/${id}`);
    }
    editAccumulatorLimit(id){
        this.props.history.push(`/add-accumulatorLimit/${id}`);
    }

    componentDidMount(){
        AccumulatorLimitService.getAccumulatorLimits().then((res) => {
            this.setState({ accumulatorLimits: res.data});
        });
    }

    addAccumulatorLimit(){
        this.props.history.push('/add-accumulatorLimit/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">AccumulatorLimit List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addAccumulatorLimit}> Add AccumulatorLimit</button>
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
                                    this.state.accumulatorLimits.map(
                                        accumulatorLimit => 
                                        <tr key = {accumulatorLimit.accumulatorLimitId}>
                                             <td> { accumulatorLimit.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editAccumulatorLimit(accumulatorLimit.accumulatorLimitId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteAccumulatorLimit(accumulatorLimit.accumulatorLimitId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewAccumulatorLimit(accumulatorLimit.accumulatorLimitId)} className="btn btn-info btn-sm">View </button>
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

export default ListAccumulatorLimitComponent
