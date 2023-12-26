import React, { Component } from 'react'
import AccumulatorService from '../services/AccumulatorService'

class ListAccumulatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                accumulators: []
        }
        this.addAccumulator = this.addAccumulator.bind(this);
        this.editAccumulator = this.editAccumulator.bind(this);
        this.deleteAccumulator = this.deleteAccumulator.bind(this);
    }

    deleteAccumulator(id){
        AccumulatorService.deleteAccumulator(id).then( res => {
            this.setState({accumulators: this.state.accumulators.filter(accumulator => accumulator.accumulatorId !== id)});
        });
    }
    viewAccumulator(id){
        this.props.history.push(`/view-accumulator/${id}`);
    }
    editAccumulator(id){
        this.props.history.push(`/add-accumulator/${id}`);
    }

    componentDidMount(){
        AccumulatorService.getAccumulators().then((res) => {
            this.setState({ accumulators: res.data});
        });
    }

    addAccumulator(){
        this.props.history.push('/add-accumulator/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Accumulator List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addAccumulator}> Add Accumulator</button>
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
                                    this.state.accumulators.map(
                                        accumulator => 
                                        <tr key = {accumulator.accumulatorId}>
                                             <td>
                                                 <button onClick={ () => this.editAccumulator(accumulator.accumulatorId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteAccumulator(accumulator.accumulatorId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewAccumulator(accumulator.accumulatorId)} className="btn btn-info btn-sm">View </button>
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

export default ListAccumulatorComponent
