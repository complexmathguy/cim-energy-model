import React, { Component } from 'react'
import AnalogLimitSetService from '../services/AnalogLimitSetService'

class ListAnalogLimitSetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                analogLimitSets: []
        }
        this.addAnalogLimitSet = this.addAnalogLimitSet.bind(this);
        this.editAnalogLimitSet = this.editAnalogLimitSet.bind(this);
        this.deleteAnalogLimitSet = this.deleteAnalogLimitSet.bind(this);
    }

    deleteAnalogLimitSet(id){
        AnalogLimitSetService.deleteAnalogLimitSet(id).then( res => {
            this.setState({analogLimitSets: this.state.analogLimitSets.filter(analogLimitSet => analogLimitSet.analogLimitSetId !== id)});
        });
    }
    viewAnalogLimitSet(id){
        this.props.history.push(`/view-analogLimitSet/${id}`);
    }
    editAnalogLimitSet(id){
        this.props.history.push(`/add-analogLimitSet/${id}`);
    }

    componentDidMount(){
        AnalogLimitSetService.getAnalogLimitSets().then((res) => {
            this.setState({ analogLimitSets: res.data});
        });
    }

    addAnalogLimitSet(){
        this.props.history.push('/add-analogLimitSet/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">AnalogLimitSet List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addAnalogLimitSet}> Add AnalogLimitSet</button>
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
                                    this.state.analogLimitSets.map(
                                        analogLimitSet => 
                                        <tr key = {analogLimitSet.analogLimitSetId}>
                                             <td>
                                                 <button onClick={ () => this.editAnalogLimitSet(analogLimitSet.analogLimitSetId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteAnalogLimitSet(analogLimitSet.analogLimitSetId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewAnalogLimitSet(analogLimitSet.analogLimitSetId)} className="btn btn-info btn-sm">View </button>
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

export default ListAnalogLimitSetComponent
