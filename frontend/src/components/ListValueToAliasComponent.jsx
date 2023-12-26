import React, { Component } from 'react'
import ValueToAliasService from '../services/ValueToAliasService'

class ListValueToAliasComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                valueToAliass: []
        }
        this.addValueToAlias = this.addValueToAlias.bind(this);
        this.editValueToAlias = this.editValueToAlias.bind(this);
        this.deleteValueToAlias = this.deleteValueToAlias.bind(this);
    }

    deleteValueToAlias(id){
        ValueToAliasService.deleteValueToAlias(id).then( res => {
            this.setState({valueToAliass: this.state.valueToAliass.filter(valueToAlias => valueToAlias.valueToAliasId !== id)});
        });
    }
    viewValueToAlias(id){
        this.props.history.push(`/view-valueToAlias/${id}`);
    }
    editValueToAlias(id){
        this.props.history.push(`/add-valueToAlias/${id}`);
    }

    componentDidMount(){
        ValueToAliasService.getValueToAliass().then((res) => {
            this.setState({ valueToAliass: res.data});
        });
    }

    addValueToAlias(){
        this.props.history.push('/add-valueToAlias/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ValueToAlias List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addValueToAlias}> Add ValueToAlias</button>
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
                                    this.state.valueToAliass.map(
                                        valueToAlias => 
                                        <tr key = {valueToAlias.valueToAliasId}>
                                             <td> { valueToAlias.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editValueToAlias(valueToAlias.valueToAliasId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteValueToAlias(valueToAlias.valueToAliasId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewValueToAlias(valueToAlias.valueToAliasId)} className="btn btn-info btn-sm">View </button>
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

export default ListValueToAliasComponent
