import React, { Component } from 'react'
import DateProxyService from '../services/DateProxyService'

class ListDateProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dateProxys: []
        }
        this.addDateProxy = this.addDateProxy.bind(this);
        this.editDateProxy = this.editDateProxy.bind(this);
        this.deleteDateProxy = this.deleteDateProxy.bind(this);
    }

    deleteDateProxy(id){
        DateProxyService.deleteDateProxy(id).then( res => {
            this.setState({dateProxys: this.state.dateProxys.filter(dateProxy => dateProxy.dateProxyId !== id)});
        });
    }
    viewDateProxy(id){
        this.props.history.push(`/view-dateProxy/${id}`);
    }
    editDateProxy(id){
        this.props.history.push(`/add-dateProxy/${id}`);
    }

    componentDidMount(){
        DateProxyService.getDateProxys().then((res) => {
            this.setState({ dateProxys: res.data});
        });
    }

    addDateProxy(){
        this.props.history.push('/add-dateProxy/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DateProxy List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDateProxy}> Add DateProxy</button>
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
                                    this.state.dateProxys.map(
                                        dateProxy => 
                                        <tr key = {dateProxy.dateProxyId}>
                                             <td>
                                                 <button onClick={ () => this.editDateProxy(dateProxy.dateProxyId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDateProxy(dateProxy.dateProxyId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDateProxy(dateProxy.dateProxyId)} className="btn btn-info btn-sm">View </button>
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

export default ListDateProxyComponent
