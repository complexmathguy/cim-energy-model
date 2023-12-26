import React, { Component } from 'react'
import DCBreakerService from '../services/DCBreakerService';

class CreateDCBreakerComponent extends Component {
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
            DCBreakerService.getDCBreakerById(this.state.id).then( (res) =>{
                let dCBreaker = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDCBreaker = (e) => {
        e.preventDefault();
        let dCBreaker = {
                dCBreakerId: this.state.id,
            };
        console.log('dCBreaker => ' + JSON.stringify(dCBreaker));

        // step 5
        if(this.state.id === '_add'){
            dCBreaker.dCBreakerId=''
            DCBreakerService.createDCBreaker(dCBreaker).then(res =>{
                this.props.history.push('/dCBreakers');
            });
        }else{
            DCBreakerService.updateDCBreaker(dCBreaker).then( res => {
                this.props.history.push('/dCBreakers');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/dCBreakers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DCBreaker</h3>
        }else{
            return <h3 className="text-center">Update DCBreaker</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDCBreaker}>Save</button>
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

export default CreateDCBreakerComponent
