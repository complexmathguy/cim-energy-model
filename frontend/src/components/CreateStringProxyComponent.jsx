import React, { Component } from 'react'
import StringProxyService from '../services/StringProxyService';

class CreateStringProxyComponent extends Component {
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
            StringProxyService.getStringProxyById(this.state.id).then( (res) =>{
                let stringProxy = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateStringProxy = (e) => {
        e.preventDefault();
        let stringProxy = {
                stringProxyId: this.state.id,
            };
        console.log('stringProxy => ' + JSON.stringify(stringProxy));

        // step 5
        if(this.state.id === '_add'){
            stringProxy.stringProxyId=''
            StringProxyService.createStringProxy(stringProxy).then(res =>{
                this.props.history.push('/stringProxys');
            });
        }else{
            StringProxyService.updateStringProxy(stringProxy).then( res => {
                this.props.history.push('/stringProxys');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/stringProxys');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add StringProxy</h3>
        }else{
            return <h3 className="text-center">Update StringProxy</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateStringProxy}>Save</button>
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

export default CreateStringProxyComponent
