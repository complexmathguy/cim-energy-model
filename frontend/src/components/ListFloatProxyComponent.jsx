import React, { Component } from 'react'
import FloatProxyService from '../services/FloatProxyService'

class ListFloatProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                floatProxys: []
        }
        this.addFloatProxy = this.addFloatProxy.bind(this);
        this.editFloatProxy = this.editFloatProxy.bind(this);
        this.deleteFloatProxy = this.deleteFloatProxy.bind(this);
    }

    deleteFloatProxy(id){
        FloatProxyService.deleteFloatProxy(id).then( res => {
            this.setState({floatProxys: this.state.floatProxys.filter(floatProxy => floatProxy.floatProxyId !== id)});
        });
    }
    viewFloatProxy(id){
        this.props.history.push(`/view-floatProxy/${id}`);
    }
    editFloatProxy(id){
        this.props.history.push(`/add-floatProxy/${id}`);
    }

    componentDidMount(){
        FloatProxyService.getFloatProxys().then((res) => {
            this.setState({ floatProxys: res.data});
        });
    }

    addFloatProxy(){
        this.props.history.push('/add-floatProxy/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">FloatProxy List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addFloatProxy}> Add FloatProxy</button>
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
                                    this.state.floatProxys.map(
                                        floatProxy => 
                                        <tr key = {floatProxy.floatProxyId}>
                                             <td>
                                                 <button onClick={ () => this.editFloatProxy(floatProxy.floatProxyId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteFloatProxy(floatProxy.floatProxyId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewFloatProxy(floatProxy.floatProxyId)} className="btn btn-info btn-sm">View </button>
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

export default ListFloatProxyComponent
