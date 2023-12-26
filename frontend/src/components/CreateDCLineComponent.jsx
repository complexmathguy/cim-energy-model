import React, { Component } from 'react'
import DCLineService from '../services/DCLineService';

class CreateDCLineComponent extends Component {
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
            DCLineService.getDCLineById(this.state.id).then( (res) =>{
                let dCLine = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDCLine = (e) => {
        e.preventDefault();
        let dCLine = {
                dCLineId: this.state.id,
            };
        console.log('dCLine => ' + JSON.stringify(dCLine));

        // step 5
        if(this.state.id === '_add'){
            dCLine.dCLineId=''
            DCLineService.createDCLine(dCLine).then(res =>{
                this.props.history.push('/dCLines');
            });
        }else{
            DCLineService.updateDCLine(dCLine).then( res => {
                this.props.history.push('/dCLines');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/dCLines');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DCLine</h3>
        }else{
            return <h3 className="text-center">Update DCLine</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDCLine}>Save</button>
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

export default CreateDCLineComponent
