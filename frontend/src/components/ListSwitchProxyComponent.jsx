import React, { Component } from 'react'
import SwitchProxyService from '../services/SwitchProxyService'

class ListSwitchProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                switchProxys: []
        }
        this.addSwitchProxy = this.addSwitchProxy.bind(this);
        this.editSwitchProxy = this.editSwitchProxy.bind(this);
        this.deleteSwitchProxy = this.deleteSwitchProxy.bind(this);
    }

    deleteSwitchProxy(id){
        SwitchProxyService.deleteSwitchProxy(id).then( res => {
            this.setState({switchProxys: this.state.switchProxys.filter(switchProxy => switchProxy.switchProxyId !== id)});
        });
    }
    viewSwitchProxy(id){
        this.props.history.push(`/view-switchProxy/${id}`);
    }
    editSwitchProxy(id){
        this.props.history.push(`/add-switchProxy/${id}`);
    }

    componentDidMount(){
        SwitchProxyService.getSwitchProxys().then((res) => {
            this.setState({ switchProxys: res.data});
        });
    }

    addSwitchProxy(){
        this.props.history.push('/add-switchProxy/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SwitchProxy List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSwitchProxy}> Add SwitchProxy</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> NormalOpen </th>
                                    <th> RatedCurrent </th>
                                    <th> Retained </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.switchProxys.map(
                                        switchProxy => 
                                        <tr key = {switchProxy.switchProxyId}>
                                             <td> { switchProxy.normalOpen } </td>
                                             <td> { switchProxy.ratedCurrent } </td>
                                             <td> { switchProxy.retained } </td>
                                             <td>
                                                 <button onClick={ () => this.editSwitchProxy(switchProxy.switchProxyId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSwitchProxy(switchProxy.switchProxyId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSwitchProxy(switchProxy.switchProxyId)} className="btn btn-info btn-sm">View </button>
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

export default ListSwitchProxyComponent
