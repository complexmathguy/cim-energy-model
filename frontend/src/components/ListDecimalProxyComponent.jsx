import React, { Component } from 'react'
import DecimalProxyService from '../services/DecimalProxyService'

class ListDecimalProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                decimalProxys: []
        }
        this.addDecimalProxy = this.addDecimalProxy.bind(this);
        this.editDecimalProxy = this.editDecimalProxy.bind(this);
        this.deleteDecimalProxy = this.deleteDecimalProxy.bind(this);
    }

    deleteDecimalProxy(id){
        DecimalProxyService.deleteDecimalProxy(id).then( res => {
            this.setState({decimalProxys: this.state.decimalProxys.filter(decimalProxy => decimalProxy.decimalProxyId !== id)});
        });
    }
    viewDecimalProxy(id){
        this.props.history.push(`/view-decimalProxy/${id}`);
    }
    editDecimalProxy(id){
        this.props.history.push(`/add-decimalProxy/${id}`);
    }

    componentDidMount(){
        DecimalProxyService.getDecimalProxys().then((res) => {
            this.setState({ decimalProxys: res.data});
        });
    }

    addDecimalProxy(){
        this.props.history.push('/add-decimalProxy/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DecimalProxy List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDecimalProxy}> Add DecimalProxy</button>
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
                                    this.state.decimalProxys.map(
                                        decimalProxy => 
                                        <tr key = {decimalProxy.decimalProxyId}>
                                             <td>
                                                 <button onClick={ () => this.editDecimalProxy(decimalProxy.decimalProxyId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDecimalProxy(decimalProxy.decimalProxyId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDecimalProxy(decimalProxy.decimalProxyId)} className="btn btn-info btn-sm">View </button>
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

export default ListDecimalProxyComponent
