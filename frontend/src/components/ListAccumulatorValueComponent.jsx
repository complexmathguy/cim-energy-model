import React, { Component } from 'react'
import AccumulatorValueService from '../services/AccumulatorValueService'

class ListAccumulatorValueComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                accumulatorValues: []
        }
        this.addAccumulatorValue = this.addAccumulatorValue.bind(this);
        this.editAccumulatorValue = this.editAccumulatorValue.bind(this);
        this.deleteAccumulatorValue = this.deleteAccumulatorValue.bind(this);
    }

    deleteAccumulatorValue(id){
        AccumulatorValueService.deleteAccumulatorValue(id).then( res => {
            this.setState({accumulatorValues: this.state.accumulatorValues.filter(accumulatorValue => accumulatorValue.accumulatorValueId !== id)});
        });
    }
    viewAccumulatorValue(id){
        this.props.history.push(`/view-accumulatorValue/${id}`);
    }
    editAccumulatorValue(id){
        this.props.history.push(`/add-accumulatorValue/${id}`);
    }

    componentDidMount(){
        AccumulatorValueService.getAccumulatorValues().then((res) => {
            this.setState({ accumulatorValues: res.data});
        });
    }

    addAccumulatorValue(){
        this.props.history.push('/add-accumulatorValue/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">AccumulatorValue List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addAccumulatorValue}> Add AccumulatorValue</button>
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
                                    this.state.accumulatorValues.map(
                                        accumulatorValue => 
                                        <tr key = {accumulatorValue.accumulatorValueId}>
                                             <td> { accumulatorValue.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editAccumulatorValue(accumulatorValue.accumulatorValueId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteAccumulatorValue(accumulatorValue.accumulatorValueId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewAccumulatorValue(accumulatorValue.accumulatorValueId)} className="btn btn-info btn-sm">View </button>
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

export default ListAccumulatorValueComponent
