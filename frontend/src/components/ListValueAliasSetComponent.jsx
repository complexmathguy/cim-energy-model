import React, { Component } from 'react'
import ValueAliasSetService from '../services/ValueAliasSetService'

class ListValueAliasSetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                valueAliasSets: []
        }
        this.addValueAliasSet = this.addValueAliasSet.bind(this);
        this.editValueAliasSet = this.editValueAliasSet.bind(this);
        this.deleteValueAliasSet = this.deleteValueAliasSet.bind(this);
    }

    deleteValueAliasSet(id){
        ValueAliasSetService.deleteValueAliasSet(id).then( res => {
            this.setState({valueAliasSets: this.state.valueAliasSets.filter(valueAliasSet => valueAliasSet.valueAliasSetId !== id)});
        });
    }
    viewValueAliasSet(id){
        this.props.history.push(`/view-valueAliasSet/${id}`);
    }
    editValueAliasSet(id){
        this.props.history.push(`/add-valueAliasSet/${id}`);
    }

    componentDidMount(){
        ValueAliasSetService.getValueAliasSets().then((res) => {
            this.setState({ valueAliasSets: res.data});
        });
    }

    addValueAliasSet(){
        this.props.history.push('/add-valueAliasSet/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ValueAliasSet List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addValueAliasSet}> Add ValueAliasSet</button>
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
                                    this.state.valueAliasSets.map(
                                        valueAliasSet => 
                                        <tr key = {valueAliasSet.valueAliasSetId}>
                                             <td>
                                                 <button onClick={ () => this.editValueAliasSet(valueAliasSet.valueAliasSetId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteValueAliasSet(valueAliasSet.valueAliasSetId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewValueAliasSet(valueAliasSet.valueAliasSetId)} className="btn btn-info btn-sm">View </button>
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

export default ListValueAliasSetComponent
