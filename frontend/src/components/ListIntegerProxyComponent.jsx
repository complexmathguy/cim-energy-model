import React, { Component } from 'react'
import IntegerProxyService from '../services/IntegerProxyService'

class ListIntegerProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                integerProxys: []
        }
        this.addIntegerProxy = this.addIntegerProxy.bind(this);
        this.editIntegerProxy = this.editIntegerProxy.bind(this);
        this.deleteIntegerProxy = this.deleteIntegerProxy.bind(this);
    }

    deleteIntegerProxy(id){
        IntegerProxyService.deleteIntegerProxy(id).then( res => {
            this.setState({integerProxys: this.state.integerProxys.filter(integerProxy => integerProxy.integerProxyId !== id)});
        });
    }
    viewIntegerProxy(id){
        this.props.history.push(`/view-integerProxy/${id}`);
    }
    editIntegerProxy(id){
        this.props.history.push(`/add-integerProxy/${id}`);
    }

    componentDidMount(){
        IntegerProxyService.getIntegerProxys().then((res) => {
            this.setState({ integerProxys: res.data});
        });
    }

    addIntegerProxy(){
        this.props.history.push('/add-integerProxy/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">IntegerProxy List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addIntegerProxy}> Add IntegerProxy</button>
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
                                    this.state.integerProxys.map(
                                        integerProxy => 
                                        <tr key = {integerProxy.integerProxyId}>
                                             <td>
                                                 <button onClick={ () => this.editIntegerProxy(integerProxy.integerProxyId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteIntegerProxy(integerProxy.integerProxyId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewIntegerProxy(integerProxy.integerProxyId)} className="btn btn-info btn-sm">View </button>
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

export default ListIntegerProxyComponent
