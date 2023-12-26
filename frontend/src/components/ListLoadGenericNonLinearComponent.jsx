import React, { Component } from 'react'
import LoadGenericNonLinearService from '../services/LoadGenericNonLinearService'

class ListLoadGenericNonLinearComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                loadGenericNonLinears: []
        }
        this.addLoadGenericNonLinear = this.addLoadGenericNonLinear.bind(this);
        this.editLoadGenericNonLinear = this.editLoadGenericNonLinear.bind(this);
        this.deleteLoadGenericNonLinear = this.deleteLoadGenericNonLinear.bind(this);
    }

    deleteLoadGenericNonLinear(id){
        LoadGenericNonLinearService.deleteLoadGenericNonLinear(id).then( res => {
            this.setState({loadGenericNonLinears: this.state.loadGenericNonLinears.filter(loadGenericNonLinear => loadGenericNonLinear.loadGenericNonLinearId !== id)});
        });
    }
    viewLoadGenericNonLinear(id){
        this.props.history.push(`/view-loadGenericNonLinear/${id}`);
    }
    editLoadGenericNonLinear(id){
        this.props.history.push(`/add-loadGenericNonLinear/${id}`);
    }

    componentDidMount(){
        LoadGenericNonLinearService.getLoadGenericNonLinears().then((res) => {
            this.setState({ loadGenericNonLinears: res.data});
        });
    }

    addLoadGenericNonLinear(){
        this.props.history.push('/add-loadGenericNonLinear/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">LoadGenericNonLinear List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addLoadGenericNonLinear}> Add LoadGenericNonLinear</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Bs </th>
                                    <th> Bt </th>
                                    <th> GenericNonLinearLoadModelType </th>
                                    <th> Ls </th>
                                    <th> Lt </th>
                                    <th> Pt </th>
                                    <th> Qt </th>
                                    <th> Tp </th>
                                    <th> Tq </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.loadGenericNonLinears.map(
                                        loadGenericNonLinear => 
                                        <tr key = {loadGenericNonLinear.loadGenericNonLinearId}>
                                             <td> { loadGenericNonLinear.bs } </td>
                                             <td> { loadGenericNonLinear.bt } </td>
                                             <td> { loadGenericNonLinear.genericNonLinearLoadModelType } </td>
                                             <td> { loadGenericNonLinear.ls } </td>
                                             <td> { loadGenericNonLinear.lt } </td>
                                             <td> { loadGenericNonLinear.pt } </td>
                                             <td> { loadGenericNonLinear.qt } </td>
                                             <td> { loadGenericNonLinear.tp } </td>
                                             <td> { loadGenericNonLinear.tq } </td>
                                             <td>
                                                 <button onClick={ () => this.editLoadGenericNonLinear(loadGenericNonLinear.loadGenericNonLinearId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteLoadGenericNonLinear(loadGenericNonLinear.loadGenericNonLinearId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewLoadGenericNonLinear(loadGenericNonLinear.loadGenericNonLinearId)} className="btn btn-info btn-sm">View </button>
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

export default ListLoadGenericNonLinearComponent
