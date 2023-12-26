import React, { Component } from 'react'
import BooleanProxyService from '../services/BooleanProxyService';

class UpdateBooleanProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateBooleanProxy = this.updateBooleanProxy.bind(this);

    }

    componentDidMount(){
        BooleanProxyService.getBooleanProxyById(this.state.id).then( (res) =>{
            let booleanProxy = res.data;
            this.setState({
            });
        });
    }

    updateBooleanProxy = (e) => {
        e.preventDefault();
        let booleanProxy = {
            booleanProxyId: this.state.id,
        };
        console.log('booleanProxy => ' + JSON.stringify(booleanProxy));
        console.log('id => ' + JSON.stringify(this.state.id));
        BooleanProxyService.updateBooleanProxy(booleanProxy).then( res => {
            this.props.history.push('/booleanProxys');
        });
    }


    cancel(){
        this.props.history.push('/booleanProxys');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update BooleanProxy</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateBooleanProxy}>Save</button>
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

export default UpdateBooleanProxyComponent
