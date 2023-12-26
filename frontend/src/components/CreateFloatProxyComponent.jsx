import React, { Component } from 'react'
import FloatProxyService from '../services/FloatProxyService';

class CreateFloatProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            FloatProxyService.getFloatProxyById(this.state.id).then( (res) =>{
                let floatProxy = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateFloatProxy = (e) => {
        e.preventDefault();
        let floatProxy = {
                floatProxyId: this.state.id,
            };
        console.log('floatProxy => ' + JSON.stringify(floatProxy));

        // step 5
        if(this.state.id === '_add'){
            floatProxy.floatProxyId=''
            FloatProxyService.createFloatProxy(floatProxy).then(res =>{
                this.props.history.push('/floatProxys');
            });
        }else{
            FloatProxyService.updateFloatProxy(floatProxy).then( res => {
                this.props.history.push('/floatProxys');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/floatProxys');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add FloatProxy</h3>
        }else{
            return <h3 className="text-center">Update FloatProxy</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateFloatProxy}>Save</button>
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

export default CreateFloatProxyComponent
