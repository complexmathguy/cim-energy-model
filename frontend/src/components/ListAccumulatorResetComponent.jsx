import React, { Component } from 'react'
import AccumulatorResetService from '../services/AccumulatorResetService'

class ListAccumulatorResetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                accumulatorResets: []
        }
        this.addAccumulatorReset = this.addAccumulatorReset.bind(this);
        this.editAccumulatorReset = this.editAccumulatorReset.bind(this);
        this.deleteAccumulatorReset = this.deleteAccumulatorReset.bind(this);
    }

    deleteAccumulatorReset(id){
        AccumulatorResetService.deleteAccumulatorReset(id).then( res => {
            this.setState({accumulatorResets: this.state.accumulatorResets.filter(accumulatorReset => accumulatorReset.accumulatorResetId !== id)});
        });
    }
    viewAccumulatorReset(id){
        this.props.history.push(`/view-accumulatorReset/${id}`);
    }
    editAccumulatorReset(id){
        this.props.history.push(`/add-accumulatorReset/${id}`);
    }

    componentDidMount(){
        AccumulatorResetService.getAccumulatorResets().then((res) => {
            this.setState({ accumulatorResets: res.data});
        });
    }

    addAccumulatorReset(){
        this.props.history.push('/add-accumulatorReset/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">AccumulatorReset List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addAccumulatorReset}> Add AccumulatorReset</button>
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
                                    this.state.accumulatorResets.map(
                                        accumulatorReset => 
                                        <tr key = {accumulatorReset.accumulatorResetId}>
                                             <td>
                                                 <button onClick={ () => this.editAccumulatorReset(accumulatorReset.accumulatorResetId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteAccumulatorReset(accumulatorReset.accumulatorResetId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewAccumulatorReset(accumulatorReset.accumulatorResetId)} className="btn btn-info btn-sm">View </button>
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

export default ListAccumulatorResetComponent
