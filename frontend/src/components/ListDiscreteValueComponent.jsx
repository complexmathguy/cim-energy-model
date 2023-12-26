import React, { Component } from 'react'
import DiscreteValueService from '../services/DiscreteValueService'

class ListDiscreteValueComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                discreteValues: []
        }
        this.addDiscreteValue = this.addDiscreteValue.bind(this);
        this.editDiscreteValue = this.editDiscreteValue.bind(this);
        this.deleteDiscreteValue = this.deleteDiscreteValue.bind(this);
    }

    deleteDiscreteValue(id){
        DiscreteValueService.deleteDiscreteValue(id).then( res => {
            this.setState({discreteValues: this.state.discreteValues.filter(discreteValue => discreteValue.discreteValueId !== id)});
        });
    }
    viewDiscreteValue(id){
        this.props.history.push(`/view-discreteValue/${id}`);
    }
    editDiscreteValue(id){
        this.props.history.push(`/add-discreteValue/${id}`);
    }

    componentDidMount(){
        DiscreteValueService.getDiscreteValues().then((res) => {
            this.setState({ discreteValues: res.data});
        });
    }

    addDiscreteValue(){
        this.props.history.push('/add-discreteValue/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DiscreteValue List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDiscreteValue}> Add DiscreteValue</button>
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
                                    this.state.discreteValues.map(
                                        discreteValue => 
                                        <tr key = {discreteValue.discreteValueId}>
                                             <td> { discreteValue.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editDiscreteValue(discreteValue.discreteValueId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDiscreteValue(discreteValue.discreteValueId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDiscreteValue(discreteValue.discreteValueId)} className="btn btn-info btn-sm">View </button>
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

export default ListDiscreteValueComponent
