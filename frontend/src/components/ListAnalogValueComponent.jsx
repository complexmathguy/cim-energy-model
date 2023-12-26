import React, { Component } from 'react'
import AnalogValueService from '../services/AnalogValueService'

class ListAnalogValueComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                analogValues: []
        }
        this.addAnalogValue = this.addAnalogValue.bind(this);
        this.editAnalogValue = this.editAnalogValue.bind(this);
        this.deleteAnalogValue = this.deleteAnalogValue.bind(this);
    }

    deleteAnalogValue(id){
        AnalogValueService.deleteAnalogValue(id).then( res => {
            this.setState({analogValues: this.state.analogValues.filter(analogValue => analogValue.analogValueId !== id)});
        });
    }
    viewAnalogValue(id){
        this.props.history.push(`/view-analogValue/${id}`);
    }
    editAnalogValue(id){
        this.props.history.push(`/add-analogValue/${id}`);
    }

    componentDidMount(){
        AnalogValueService.getAnalogValues().then((res) => {
            this.setState({ analogValues: res.data});
        });
    }

    addAnalogValue(){
        this.props.history.push('/add-analogValue/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">AnalogValue List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addAnalogValue}> Add AnalogValue</button>
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
                                    this.state.analogValues.map(
                                        analogValue => 
                                        <tr key = {analogValue.analogValueId}>
                                             <td> { analogValue.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editAnalogValue(analogValue.analogValueId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteAnalogValue(analogValue.analogValueId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewAnalogValue(analogValue.analogValueId)} className="btn btn-info btn-sm">View </button>
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

export default ListAnalogValueComponent
