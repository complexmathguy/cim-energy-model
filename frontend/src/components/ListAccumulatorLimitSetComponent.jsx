import React, { Component } from 'react'
import AccumulatorLimitSetService from '../services/AccumulatorLimitSetService'

class ListAccumulatorLimitSetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                accumulatorLimitSets: []
        }
        this.addAccumulatorLimitSet = this.addAccumulatorLimitSet.bind(this);
        this.editAccumulatorLimitSet = this.editAccumulatorLimitSet.bind(this);
        this.deleteAccumulatorLimitSet = this.deleteAccumulatorLimitSet.bind(this);
    }

    deleteAccumulatorLimitSet(id){
        AccumulatorLimitSetService.deleteAccumulatorLimitSet(id).then( res => {
            this.setState({accumulatorLimitSets: this.state.accumulatorLimitSets.filter(accumulatorLimitSet => accumulatorLimitSet.accumulatorLimitSetId !== id)});
        });
    }
    viewAccumulatorLimitSet(id){
        this.props.history.push(`/view-accumulatorLimitSet/${id}`);
    }
    editAccumulatorLimitSet(id){
        this.props.history.push(`/add-accumulatorLimitSet/${id}`);
    }

    componentDidMount(){
        AccumulatorLimitSetService.getAccumulatorLimitSets().then((res) => {
            this.setState({ accumulatorLimitSets: res.data});
        });
    }

    addAccumulatorLimitSet(){
        this.props.history.push('/add-accumulatorLimitSet/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">AccumulatorLimitSet List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addAccumulatorLimitSet}> Add AccumulatorLimitSet</button>
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
                                    this.state.accumulatorLimitSets.map(
                                        accumulatorLimitSet => 
                                        <tr key = {accumulatorLimitSet.accumulatorLimitSetId}>
                                             <td>
                                                 <button onClick={ () => this.editAccumulatorLimitSet(accumulatorLimitSet.accumulatorLimitSetId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteAccumulatorLimitSet(accumulatorLimitSet.accumulatorLimitSetId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewAccumulatorLimitSet(accumulatorLimitSet.accumulatorLimitSetId)} className="btn btn-info btn-sm">View </button>
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

export default ListAccumulatorLimitSetComponent
