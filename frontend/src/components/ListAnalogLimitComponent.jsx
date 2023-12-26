import React, { Component } from 'react'
import AnalogLimitService from '../services/AnalogLimitService'

class ListAnalogLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                analogLimits: []
        }
        this.addAnalogLimit = this.addAnalogLimit.bind(this);
        this.editAnalogLimit = this.editAnalogLimit.bind(this);
        this.deleteAnalogLimit = this.deleteAnalogLimit.bind(this);
    }

    deleteAnalogLimit(id){
        AnalogLimitService.deleteAnalogLimit(id).then( res => {
            this.setState({analogLimits: this.state.analogLimits.filter(analogLimit => analogLimit.analogLimitId !== id)});
        });
    }
    viewAnalogLimit(id){
        this.props.history.push(`/view-analogLimit/${id}`);
    }
    editAnalogLimit(id){
        this.props.history.push(`/add-analogLimit/${id}`);
    }

    componentDidMount(){
        AnalogLimitService.getAnalogLimits().then((res) => {
            this.setState({ analogLimits: res.data});
        });
    }

    addAnalogLimit(){
        this.props.history.push('/add-analogLimit/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">AnalogLimit List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addAnalogLimit}> Add AnalogLimit</button>
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
                                    this.state.analogLimits.map(
                                        analogLimit => 
                                        <tr key = {analogLimit.analogLimitId}>
                                             <td> { analogLimit.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editAnalogLimit(analogLimit.analogLimitId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteAnalogLimit(analogLimit.analogLimitId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewAnalogLimit(analogLimit.analogLimitId)} className="btn btn-info btn-sm">View </button>
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

export default ListAnalogLimitComponent
