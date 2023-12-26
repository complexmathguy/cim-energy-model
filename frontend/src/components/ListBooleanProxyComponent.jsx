import React, { Component } from 'react'
import BooleanProxyService from '../services/BooleanProxyService'

class ListBooleanProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                booleanProxys: []
        }
        this.addBooleanProxy = this.addBooleanProxy.bind(this);
        this.editBooleanProxy = this.editBooleanProxy.bind(this);
        this.deleteBooleanProxy = this.deleteBooleanProxy.bind(this);
    }

    deleteBooleanProxy(id){
        BooleanProxyService.deleteBooleanProxy(id).then( res => {
            this.setState({booleanProxys: this.state.booleanProxys.filter(booleanProxy => booleanProxy.booleanProxyId !== id)});
        });
    }
    viewBooleanProxy(id){
        this.props.history.push(`/view-booleanProxy/${id}`);
    }
    editBooleanProxy(id){
        this.props.history.push(`/add-booleanProxy/${id}`);
    }

    componentDidMount(){
        BooleanProxyService.getBooleanProxys().then((res) => {
            this.setState({ booleanProxys: res.data});
        });
    }

    addBooleanProxy(){
        this.props.history.push('/add-booleanProxy/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">BooleanProxy List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addBooleanProxy}> Add BooleanProxy</button>
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
                                    this.state.booleanProxys.map(
                                        booleanProxy => 
                                        <tr key = {booleanProxy.booleanProxyId}>
                                             <td>
                                                 <button onClick={ () => this.editBooleanProxy(booleanProxy.booleanProxyId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteBooleanProxy(booleanProxy.booleanProxyId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewBooleanProxy(booleanProxy.booleanProxyId)} className="btn btn-info btn-sm">View </button>
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

export default ListBooleanProxyComponent
