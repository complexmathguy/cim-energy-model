import React, { Component } from 'react'
import StringProxyService from '../services/StringProxyService'

class ListStringProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                stringProxys: []
        }
        this.addStringProxy = this.addStringProxy.bind(this);
        this.editStringProxy = this.editStringProxy.bind(this);
        this.deleteStringProxy = this.deleteStringProxy.bind(this);
    }

    deleteStringProxy(id){
        StringProxyService.deleteStringProxy(id).then( res => {
            this.setState({stringProxys: this.state.stringProxys.filter(stringProxy => stringProxy.stringProxyId !== id)});
        });
    }
    viewStringProxy(id){
        this.props.history.push(`/view-stringProxy/${id}`);
    }
    editStringProxy(id){
        this.props.history.push(`/add-stringProxy/${id}`);
    }

    componentDidMount(){
        StringProxyService.getStringProxys().then((res) => {
            this.setState({ stringProxys: res.data});
        });
    }

    addStringProxy(){
        this.props.history.push('/add-stringProxy/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">StringProxy List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addStringProxy}> Add StringProxy</button>
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
                                    this.state.stringProxys.map(
                                        stringProxy => 
                                        <tr key = {stringProxy.stringProxyId}>
                                             <td>
                                                 <button onClick={ () => this.editStringProxy(stringProxy.stringProxyId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteStringProxy(stringProxy.stringProxyId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewStringProxy(stringProxy.stringProxyId)} className="btn btn-info btn-sm">View </button>
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

export default ListStringProxyComponent
