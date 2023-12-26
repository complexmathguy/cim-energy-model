import React, { Component } from 'react'
import FloatProxyService from '../services/FloatProxyService';

class UpdateFloatProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateFloatProxy = this.updateFloatProxy.bind(this);

    }

    componentDidMount(){
        FloatProxyService.getFloatProxyById(this.state.id).then( (res) =>{
            let floatProxy = res.data;
            this.setState({
            });
        });
    }

    updateFloatProxy = (e) => {
        e.preventDefault();
        let floatProxy = {
            floatProxyId: this.state.id,
        };
        console.log('floatProxy => ' + JSON.stringify(floatProxy));
        console.log('id => ' + JSON.stringify(this.state.id));
        FloatProxyService.updateFloatProxy(floatProxy).then( res => {
            this.props.history.push('/floatProxys');
        });
    }


    cancel(){
        this.props.history.push('/floatProxys');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update FloatProxy</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateFloatProxy}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateFloatProxyComponent
